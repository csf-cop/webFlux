package com.csf.csfdatabase.tmp.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.topcoder.idtool.entities.responses.PagingResponse;
import org.springframework.stereotype.Service;
import com.topcoder.idtool.entities.Attendee;
import com.topcoder.idtool.entities.MeetingLog;
import com.topcoder.idtool.entities.requests.CommonSearchRequest;
import com.topcoder.idtool.entities.requests.GetMeetingAttendeesRequest;
import com.topcoder.idtool.entities.requests.GetMyMeetingLogsRequest;
import com.topcoder.idtool.entities.requests.PagingRequest;
import com.topcoder.idtool.entities.requests.SortOrder;

/**
 * The meeting log service.
 */
@Service
public class MeetingLogService extends BaseService {

  /**
   * The list of properties that are allowed for sorting.
   */
  private static final List<String> ALLOWED_SORT_COLUMNS =
      Arrays.asList("sessionID", "name", "leader", "startDate", "endDate", "attendeesNumber");

  /**
   * Get meeting logs hosted by me.
   * 
   * @param searchRequest the search request
   * @param pagingRequest the paging request
   * @return the meeting logs
   */
  public PagingResponse getMyMeetingLogs(GetMyMeetingLogsRequest searchRequest,
      PagingRequest pagingRequest) {
    return getMeetingLogs(searchRequest, pagingRequest, "spGetMeetingLogs");
  }

  /**
   * Get all the meeting logs.
   * 
   * @param searchRequest the search request
   * @param pagingRequest the paging request
   * @return the meeting logs
   */
  public PagingResponse getAllMeetingLogs(CommonSearchRequest searchRequest,
      PagingRequest pagingRequest) {
    return getMeetingLogs(searchRequest, pagingRequest, "spGetMeetingLogs");
  }

  /**
   * Get all the meeting logs of my reporters.
   * 
   * @param searchRequest the search request
   * @param pagingRequest the paging request
   * @return the meeting logs
   */
  public PagingResponse getMyReportersLogs(GetMyMeetingLogsRequest searchRequest,
      PagingRequest pagingRequest) {
    return getMeetingLogs(searchRequest, pagingRequest, "spGetMyReportersLogs");
  }

  /**
   * Get all the meeting logs that my reportees didn't attend.
   * 
   * @param searchRequest the search request
   * @param pagingRequest the paging request
   * @return the meeting logs
   */
  public PagingResponse getAttendanceLogs(GetMyMeetingLogsRequest searchRequest,
      PagingRequest pagingRequest) {
    return getMeetingLogs(searchRequest, pagingRequest, "spGetAttendanceLogs");
  }

  /**
   * Get the attendees info of a session.
   * 
   * @param request the request
   * @return the meeting logs
   */
  public PagingResponse getMeetingAttendees(GetMeetingAttendeesRequest request) {
    return executeSp("spGetMeetingAttendees", Arrays.asList("AttendeeSessionID"),
        Arrays.asList(Integer.class), Arrays.asList(request.getSessionId()), result -> {
          int resultIndex = 0;
          return Attendee.builder() //
              .signInTime((Date) result[resultIndex++]) //
              .attendee((String) result[resultIndex++]) //
              .email((String) result[resultIndex++]) //
              .supervisor((String) result[resultIndex++]) //
              .build();
        }, false);
  }

  /**
   * Get the meeting logs.
   * 
   * @param searchRequest the search request
   * @param pagingRequest the paging request
   * @param spName the Stored Procedure name
   * @return the meeting logs
   */
  @SuppressWarnings("rawtypes")
  private PagingResponse getMeetingLogs(CommonSearchRequest searchRequest,
                                        PagingRequest pagingRequest, String spName) {
    validateSortColumn(ALLOWED_SORT_COLUMNS, pagingRequest.getSortBy());

    List<String> parameterNames = new ArrayList<>();
    List<Class> parameterClasses = new ArrayList<>();
    List<Object> parameterValues = new ArrayList<>();

    parameterNames.add("StartDateTime");
    parameterClasses.add(Date.class);
    parameterValues.add(searchRequest.getStartDate());

    parameterNames.add("EndDateTime");
    parameterClasses.add(Date.class);
    parameterValues.add(searchRequest.getEndDate());

    parameterNames.add("UserID");
    parameterClasses.add(String.class);
    parameterValues.add(searchRequest instanceof GetMyMeetingLogsRequest
        ? ((GetMyMeetingLogsRequest) searchRequest).getUserId() : null);

    parameterNames.add("KeywordsList");
    parameterClasses.add(String.class);
    parameterValues.add(searchRequest.getKeyword() == null ? ""
            : String.join("|", searchRequest.getKeyword()));

    parameterNames.add("pageIndex");
    parameterClasses.add(Integer.class);
    parameterValues.add(pagingRequest.getPageIndex());

    parameterNames.add("pageNo");
    parameterClasses.add(Integer.class);
    parameterValues.add(pagingRequest.getPageNo());

    parameterNames.add("sortOrder");
    parameterClasses.add(String.class);
    parameterValues.add(pagingRequest.getSortOrder() == null ? SortOrder.ASC.toString()
        : pagingRequest.getSortOrder().toString());

    parameterNames.add("sortBy");
    parameterClasses.add(String.class);
    parameterValues.add(pagingRequest.getSortBy());

    return executeSp(spName, parameterNames, parameterClasses, parameterValues, result -> {
      int resultIndex = 0;
      return MeetingLog.builder() //
          .sessionID((Integer) result[resultIndex++]) //
          .name((String) result[resultIndex++]) //
          .leader((String) result[resultIndex++]) //
          .startDate((Date) result[resultIndex++]) //
          .endDate((Date) result[resultIndex++]) //
          .notes((String) result[resultIndex++]) //
          .attendeesNumber((Integer) result[resultIndex++]) //
          .build();
    }, true);
  }
}
