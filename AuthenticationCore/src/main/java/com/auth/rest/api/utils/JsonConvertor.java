package com.auth.rest.api.utils;

import java.sql.ResultSet;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 
 * @author mmerabti
 * @since 22 mars 2016.  API version : 1.0
 * @version 1.0
 * 
 *          {@inheritDoc}
 */

public class JsonConvertor {

    /**
     * Convert a result set into a JSON Array
     * 
     * @param resultSet
     * @return a JSONArray
     * @throws Exception
     */
    public static JSONArray convertToJSON(ResultSet resultSet) throws Exception {
        JSONArray jsonArray = new JSONArray();
        while (resultSet.next()) {
            int total_rows = resultSet.getMetaData().getColumnCount();
            JSONObject obj = new JSONObject();
            for (int i = 0; i < total_rows; i++) {
                obj.put(resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase(), resultSet.getObject(i + 1));
                jsonArray.put(obj);
            }
        }
        return jsonArray;
    }

    /**
     * Convert a result set into a XML List
     * 
     * @param resultSet
     * @return a XML String with list elements
     * @throws Exception
     *             if something happens
     */
    public static String convertToXML(ResultSet resultSet) throws Exception {
        StringBuffer xmlArray = new StringBuffer("&lt;results&gt;");
        while (resultSet.next()) {
            int total_rows = resultSet.getMetaData().getColumnCount();
            xmlArray.append("&lt;result ");
            for (int i = 0; i < total_rows; i++) {
                xmlArray.append(" " + resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase() + "='" + resultSet.getObject(i + 1) + "'");
            }
            xmlArray.append(" /&gt;");
        }
        xmlArray.append("&lt;/results&gt;");
        return xmlArray.toString();
    }

}
