package DBHelper;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class books extends DBHelper {
	private final String TABLE_NAME = "books";
	public static final String barcode = "barcode";
	public static final String title = "title";
	public static final String author = "author";
	public static final String genre = "genre";
	public static final String status = "status";
	public static final String due_date = "due_date";


	/*
	prepareSQL
	Purpose: prepares the text of a SQL "select" command.
	Return type: String
	Arguments:
		fields: the fields to be displayed in the output
		whatField: field to search for
		whatValue: value to search for within whatField
		sort: use ASC or DESC to specify the sorting order
		sortField: the field that the data will be sorted by
	 */
	private String prepareSQL(String fields, String whatField, String whatValue, String sortField, String sort) {
		String query = "SELECT ";
		query += fields == null ? " * FROM " + TABLE_NAME : fields + " FROM " + TABLE_NAME;
		query += whatField != null && whatValue != null ? " WHERE " + whatField + " = \"" + whatValue + "\"" : "";
		query += sort != null && sortField != null ? " order by " + sortField + " " + sort : "";
		return query;
	}


	/*
	insert
	Purpose: insert a new record into the database
	Return type: void
	Arguments: each field listed in the table from the database, in order
	 */
	public void insert(Integer barcode, String title, String author, String genre, Boolean status, String due_date) {
		title = title != null ? "\"" + title + "\"" : null;
		author = author != null ? "\"" + author + "\"" : null;
		genre = genre != null ? "\"" + genre + "\"" : null;
		due_date = due_date != null ? "\"" + due_date + "\"" : null;
		
		Object[] values_ar = {barcode, title, author, genre, status, due_date};
		String[] fields_ar = {books.barcode, books.title, books.author, books.genre, books.status, books.due_date};
		String values = "", fields = "";
		for (int i = 0; i < values_ar.length; i++) {
			if (values_ar[i] != null) {
				values += values_ar[i] + ", ";
				fields += fields_ar[i] + ", ";
			}
		}
		if (!values.isEmpty()) {
			values = values.substring(0, values.length() - 2);
			fields = fields.substring(0, fields.length() - 2);
			super.execute("INSERT INTO " + TABLE_NAME + "(" + fields + ") values(" + values + ");");
		}
	}

	/*
	delete
	Purpose: remove a record from the database
	Return type: void
	Arguments: the field (key) used to determine if a row should be deleted,
	and the value that should be removed
	 */
	public void delete(String whatField, String whatValue) {
		super.execute("DELETE from " + TABLE_NAME + " where " + whatField + " = " + whatValue + ";");
	}

	/*
	update
	Purpose: update a record in the database
	Return type: void
	Arguments: the field (key) used to determine if a row should be updated,
	and the value that should be removed
 	*/
	public void update(String whatField, String whatValue, String whereField, String whereValue) {
		super.execute("UPDATE " + TABLE_NAME + " set " + whatField + " = \"" + whatValue + "\" where " + whereField + " = \"" + whereValue + "\";");
	}

	/*
	select
	Purpose: completes a SQL "select" command
	Return type: ArrayList<ArrayList<Object>> - this means it returns a 2d
	array of objects of any type
	Arguments:
		field: the fields to be displayed in the output
		whatField: field to search within
		whatValue: value to search for within whatField
		sort: use ASC or DESC to specify the sorting order
		sortField: the field that the data will be sorted by
	 */
	public ArrayList<ArrayList<Object>> select(String fields, String whatField, String whatValue, String sortField, String sort) {
		return super.executeQuery(prepareSQL(fields, whatField, whatValue, sortField, sort));
	}

	/*
	getExecuteResult
	Purpose: performs a search of the database, where String "query" is the SQL
	command that would be entered on the command line
	Return type: ArrayList<ArrayList<Object>> - this means it returns a 2d
	array of objects of any type
	Arguments query - this is the SQL command that would be entered at the command line for a SQL query
	 */
	public ArrayList<ArrayList<Object>> getExecuteResult(String query) {
		return super.executeQuery(query);
	}

	/*
	execute
	Purpose: performs a SQL command, where String query is the SQL command that would be entered on the command line
	Return type: void
	Arguments query - this is the SQL command that would be entered at the command line for a SQL query
	 */
	public void execute(String query) {
		super.execute(query);
	}

	/*
	defaultTableModel
	Purpose: performs a search of the database, where String query is the SQL command that would be entered on the command line
	Return type: DefaultTableModel - uses a vector of vectors (a table) to store data
	array of objects of any type
	Arguments:
		field: the fields to be displayed in the output
		whatField: field to search within
		whatValue: value to search for within whatField
		sort: use ASC or DESC to specify the sorting order
		sortField: the field that the data will be sorted by
	 */
	public DefaultTableModel selectToTable(String fields, String whatField, String whatValue, String sortField, String sort) {
		return super.executeQueryToTable(prepareSQL(fields, whatField, whatValue, sortField, sort));
	}

}