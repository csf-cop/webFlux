package com.csf.csfdatabase.tmp.controller;

import java.util.List;
import javax.validation.Valid;

import com.topcoder.idtool.entities.responses.PagingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import com.topcoder.idtool.entities.Attendee;
import com.topcoder.idtool.entities.MeetingLog;
import com.topcoder.idtool.entities.requests.CommonSearchRequest;
import com.topcoder.idtool.entities.requests.GetMeetingAttendeesRequest;
import com.topcoder.idtool.entities.requests.GetMyMeetingLogsRequest;
import com.topcoder.idtool.entities.requests.PagingRequest;
import com.topcoder.idtool.services.MeetingLogService;

/**
 * The controller defines all meeting log end-points.
 */
@RestController
public class MeetingLogController {

  /**
   * The meeting log service.
   */
  @Autowired
  private MeetingLogService service;

  /**
   * Get meeting logs hosted by me.
   * 
   * @param searchRequest the search request
   * @param pagingRequest the paging request
   * @return the meeting logs
   */
  @GetMapping("/getMyMeetingLogs")
  public PagingResponse getMyMeetingLogs(
      @Valid @ModelAttribute GetMyMeetingLogsRequest searchRequest,
      @Valid @ModelAttribute PagingRequest pagingRequest) {
    return service.getMyMeetingLogs(searchRequest, pagingRequest);
  }

  /**
   * Get all the meeting logs.
   * 
   * @param searchRequest the search request
   * @param pagingRequest the paging request
   * @return the meeting logs
   */
  @GetMapping("/getAllMeetingLogs")
  public PagingResponse getAllMeetingLogs(
      @Valid @ModelAttribute CommonSearchRequest searchRequest,
      @Valid @ModelAttribute PagingRequest pagingRequest) {
    return service.getAllMeetingLogs(searchRequest, pagingRequest);
  }

  /**
   * Get all the meeting logs of my reporters.
   * 
   * @param searchRequest the search request
   * @param pagingRequest the paging request
   * @return the meeting logs
   */
  @GetMapping("/getMyReportersLogs")
  public PagingResponse getMyReportersLogs(
      @Valid @ModelAttribute GetMyMeetingLogsRequest searchRequest,
      @Valid @ModelAttribute PagingRequest pagingRequest) {
    return service.getMyReportersLogs(searchRequest, pagingRequest);
  }

  /**
   * Get all the meeting logs that my reportees didn't attend.
   * 
   * @param searchRequest the search request
   * @param pagingRequest the paging request
   * @return the meeting logs
   */
  @GetMapping("/getAttendanceLogs")
  public PagingResponse getAttendanceLogs(
      @Valid @ModelAttribute GetMyMeetingLogsRequest searchRequest,
      @Valid @ModelAttribute PagingRequest pagingRequest) {
    return service.getAttendanceLogs(searchRequest, pagingRequest);
  }

  /**
   * Get the attendees info of a session.
   * 
   * @param request the request
   * @return the meeting logs
   */
  @GetMapping("/getMeetingAttendees")
  public PagingResponse getMeetingAttendees(
      @Valid @ModelAttribute GetMeetingAttendeesRequest request) {
    return service.getMeetingAttendees(request);
  }
}
