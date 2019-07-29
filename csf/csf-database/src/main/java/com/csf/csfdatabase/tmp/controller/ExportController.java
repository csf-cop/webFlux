package com.csf.csfdatabase.tmp.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.topcoder.idtool.entities.responses.PagingResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import com.topcoder.idtool.entities.ActionItem;
import com.topcoder.idtool.entities.LOTOItem;
import com.topcoder.idtool.entities.MeetingLog;
import com.topcoder.idtool.entities.requests.CommonSearchRequest;
import com.topcoder.idtool.entities.requests.ExportRequest;
import com.topcoder.idtool.entities.requests.GetActionItemsRequest;
import com.topcoder.idtool.entities.requests.GetLotosRequest;
import com.topcoder.idtool.entities.requests.PagingRequest;
import com.topcoder.idtool.services.ActionItemService;
import com.topcoder.idtool.services.LotoService;
import com.topcoder.idtool.services.MeetingLogService;

/**
 * The controller defines all export end-points.
 */
@RestController
public class ExportController {

  /**
   * The meeting log service.
   */
  @Autowired
  private MeetingLogService meetingLogService;

  /**
   * The meeting log service.
   */
  @Autowired
  private ActionItemService actionItemService;

  /**
   * The meeting log service.
   */
  @Autowired
  private LotoService lotoService;

  /**
   * Export data.
   * 
   * @param request the export request
   * @param response the HTTP response
   * @throws IOException if any error occurs when writing Excel file
   */
  @GetMapping("/export")
  public void export(@Valid @ModelAttribute ExportRequest request, HttpServletResponse response)
      throws IOException {
    String[] header;
    PagingResponse results;

    // Build the paging request to get all records
    PagingRequest pagingRequest = new PagingRequest();
    pagingRequest.setPageIndex(1);
    pagingRequest.setPageNo(Integer.MAX_VALUE);

    if ("MeetingLog".equals(request.getType())) {
      header = new String[] {"Session ID", "Name", "Leader", "Start Date", "End Date", "Notes", "Attendees Number"};

      pagingRequest.setSortBy("sessionID");

      CommonSearchRequest searchRequest = new CommonSearchRequest();
      searchRequest.setKeyword(Arrays.asList(""));

      results = meetingLogService.getAllMeetingLogs(searchRequest, pagingRequest);
    } else if ("ActionItem".equals(request.getType())) {
      header = new String[] {"Status", "Type", "Title", "MOC", "Action Item Content",
          "Assigned By", "Assigned To", "Due Date", "Completed Date"};

      pagingRequest.setSortBy("type");

      GetActionItemsRequest searchRequest = new GetActionItemsRequest();
      searchRequest.setKeyword(Arrays.asList(""));
      searchRequest.setType("All");

      results = actionItemService.getActionItems(searchRequest, pagingRequest);
    } else if ("LOTO".equals(request.getType())) {
      header = new String[] {"ID", "Loto Name", "Group Name", "Location", "Loto Date",
          "Loto Operator", "Loto Reason", "Value Process Points", "Third Party Locks",
          "Loto Removed Date", "Removed By"};

      GetLotosRequest searchRequest = new GetLotosRequest();
      searchRequest.setKeyword(Arrays.asList(""));
      searchRequest.setType("All");
      searchRequest.setPageIndex(1);
      searchRequest.setPageNo(Integer.MAX_VALUE);

      results = lotoService.getLotos(searchRequest);
    } else {
      throw new IllegalArgumentException("type must be in [MeetingLog, ActionItem, LOTO]");
    }

    // Write Excel
    Workbook workbook = new HSSFWorkbook();
    Sheet sheet = workbook.createSheet();

    int rowCount = 0;
    int columnCount = 0;

    // Write header row
    Row row = sheet.createRow(rowCount++);
    for (String head : header) {
      row.createCell(columnCount++).setCellValue(head);
    }

    if(results != null) {
      // Write content rows
      for (Object result : results.getRows()) {
        row = sheet.createRow(rowCount++);
        columnCount = 0;

        if (result instanceof MeetingLog) {
          writeMeetingLog((MeetingLog) result, row);
        } else if (result instanceof ActionItem) {
          writeActionItem((ActionItem) result, row);
        } else if (result instanceof LOTOItem) {
          writeLOTOItem((LOTOItem) result, row);
        }
      }
    }

    // Write Excel to response
    response.setContentType("application/vnd.ms-excel");
    response.setHeader("Content-Disposition",
        String.format("attachment; filename=\"%s\"", request.getType() + ".xls"));

    workbook.write(response.getOutputStream());
    workbook.close();
  }

  /**
   * Write a meeting log to a row.
   * 
   * @param meetingLog the meeting log
   * @param row the row
   */
  private void writeMeetingLog(MeetingLog meetingLog, Row row) {
    int columnCount = 0;
    row.createCell(columnCount++).setCellValue(meetingLog.getSessionID());
    row.createCell(columnCount++).setCellValue(meetingLog.getName());
    row.createCell(columnCount++).setCellValue(meetingLog.getLeader());
    writeDateToCell(row.createCell(columnCount++), meetingLog.getStartDate());
    writeDateToCell(row.createCell(columnCount++), meetingLog.getEndDate());
    row.createCell(columnCount++).setCellValue(meetingLog.getNotes());
    row.createCell(columnCount++).setCellValue(meetingLog.getAttendeesNumber());
  }

  /**
   * Write action item to a row.
   * 
   * @param actionItem the action item
   * @param row the row
   */
  private void writeActionItem(ActionItem actionItem, Row row) {
    int columnCount = 0;
    row.createCell(columnCount++).setCellValue(actionItem.getStatus());
    row.createCell(columnCount++).setCellValue(actionItem.getType());
    row.createCell(columnCount++).setCellValue(actionItem.getTitle());
    row.createCell(columnCount++).setCellValue(actionItem.getMoc());
    row.createCell(columnCount++).setCellValue(actionItem.getRecommendation());
    row.createCell(columnCount++).setCellValue(actionItem.getAssignedBy());
    row.createCell(columnCount++).setCellValue(actionItem.getAssignedTo());
    writeDateToCell(row.createCell(columnCount++), actionItem.getDueDate());
    writeDateToCell(row.createCell(columnCount++), actionItem.getCompletedDate());
  }

  /**
   * Write loto item to a row.
   * 
   * @param lotoItem the loto item
   * @param row the row
   */
  private void writeLOTOItem(LOTOItem lotoItem, Row row) {
    int columnCount = 0;
    row.createCell(columnCount++).setCellValue(lotoItem.getId());
    row.createCell(columnCount++).setCellValue(lotoItem.getLotoName());
    row.createCell(columnCount++).setCellValue(lotoItem.getGroupName());
    row.createCell(columnCount++).setCellValue(lotoItem.getLocation());
    writeDateToCell(row.createCell(columnCount++), lotoItem.getLotoDate());
    row.createCell(columnCount++).setCellValue(lotoItem.getLotoOperator());
    row.createCell(columnCount++).setCellValue(lotoItem.getLotoReason());
    row.createCell(columnCount++).setCellValue(lotoItem.getValueProcessPoints());
    row.createCell(columnCount++).setCellValue(lotoItem.getThirdPartyLocks());
    writeDateToCell(row.createCell(columnCount++), lotoItem.getLotoRemovedDate());
    row.createCell(columnCount++).setCellValue(lotoItem.getRemovedBy());
  }

  /**
   * Write a date value to Excel cell.
   * 
   * @param cell the cell
   * @param value the value
   */
  private void writeDateToCell(Cell cell, Date value) {
    if (value == null) {
      return;
    }

    CellStyle cellStyle = cell.getRow().getSheet().getWorkbook().createCellStyle();
    cellStyle.setDataFormat((short) 14); // m/d/yy
    cell.setCellStyle(cellStyle);

    cell.setCellValue(value);
  }
}
