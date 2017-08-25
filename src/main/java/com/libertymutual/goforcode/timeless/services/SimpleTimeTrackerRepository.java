package com.libertymutual.goforcode.timeless.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.text.SimpleDateFormat;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.libertymutual.goforcode.timeless.models.TimesheetItem;

@Service
public class SimpleTimeTrackerRepository {

	private ArrayList<TimesheetItem> timesheet;

	public SimpleTimeTrackerRepository() {
		timesheet = new ArrayList<TimesheetItem>();
	}

	public List<TimesheetItem> getAll() {

		try (FileReader reader = new FileReader("Timesheet.csv")) {

			for (CSVRecord current : CSVFormat.DEFAULT.parse(reader).getRecords()) {

				TimesheetItem item = new TimesheetItem();
				item.setDate(current.get(0));
				item.setMondayHours(Double.parseDouble(current.get(1)));
				item.setTuesdayHours(Double.parseDouble(current.get(2)));
				item.setWednesdayHours(Double.parseDouble(current.get(3)));
				item.setThursdayHours(Double.parseDouble(current.get(4)));
				item.setFridayHours(Double.parseDouble(current.get(5)));
				item.setSum(Double.parseDouble(current.get(6)));
				timesheet.add(item);

			}

		} catch (FileNotFoundException e) {
			System.out.println("Could not read file");
		} catch (IOException e) {
			System.out.println("Could not read file1");

		}
		if (timesheet.size() == 0) {
			return Collections.emptyList();
		}

		return timesheet;

	}

	
	public void create(TimesheetItem item) {

		try (FileWriter writer = new FileWriter("Timesheet.csv", true);
                CSVPrinter printer = CSVFormat.DEFAULT.print(writer)) {
            String[] current = { item.getDate(), 
                    Double.toString(item.getMondays()),
                    Double.toString(item.getTuesdays()), 
                    Double.toString(item.getWednesdays()),
                    Double.toString(item.getThursdays()), 
                    Double.toString(item.getFridays()),
                    Double.toString(item.getSum()) };
            
            printer.printRecord(current);

		} catch (FileNotFoundException e) {
			System.out.println("Could not find file.");
		} catch (IOException e) {
			System.out.println("Could not read file2");

		}

	}

	// 
	// public ToDoItem getById(int id) {
	// for (ToDoItem item :items) {
	// if (id ==item.getId()) {
	// return item;
	// }
	// }
	//
	// return null;
	// }
	//
	//
	//
	//
	//
	// public void update(ToDoItem updatedItem) {
	//
	// for (ToDoItem item : items) {
	// if (updatedItem.getId() == item.getId()) {
	//
	// item.setComplete(item.isComplete());
	//
	// }
	// }
	//
	// try
	// (FileWriter writer = new FileWriter("ToDo.csv");
	//
	// CSVPrinter printer = CSVFormat.DEFAULT.print(writer)){
	//
	// for (ToDoItem item : items) {
	//
	//
	// String[] record = new String[3];
	// record = new String [] {String.valueOf(item.getId()), item.getText(),
	// String.valueOf(item.isComplete())};
	//
	// printer.printRecord(record);
	//
	//
	// }
	//
	// } catch (FileNotFoundException e) {
	// System.out.println("Could not find file.");
	// } catch (IOException e) {
	// System.out.println("Could not read file3");
	//
	// }
	// }
}
