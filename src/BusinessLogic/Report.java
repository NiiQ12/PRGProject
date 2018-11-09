/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import Presentation.AdminMain;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Date;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author P3STctrl
 */
public class Report
{

    public static void GenerateStockReport() throws SQLException, ClassNotFoundException, IOException
    {
        List<Stationery> stationeries = Stationery.GetStationery("", 0);
        List<Category> categories = Category.GetCategories();

        Writer w = new FileWriter(new File("Report_Stock.txt"));
        w.write("\t\t\t============================\n");
        w.write("\t\t\t|  AVAILABLE STOCK REPORT  |\n");
        w.write("\t\t\t============================\n\n");

        for (Category category : categories)
        {
            w.write("CATEGORY : " + category.getDescription() + "\n");

            w.write("---------------------------------------------------------------------------------\n");
            w.write(String.format("%-10s%-30s%-10s%-10s%s\n", "CODE", "DESCRIPTION", "STOCK", "PRICE", "MANUFACTURER"));
            w.write("---------------------------------------------------------------------------------\n");

            for (Stationery s : stationeries)
            {
                if (s.getCategory().equals(category.getDescription()))
                {
                    w.write(String.format("%-10d%-30s%-10d%s %6.2f  %s\n", s.getStationeryCode(), s.getDescription(), s.getStock(), NumberFormat.getCurrencyInstance().getCurrency().getSymbol(), s.getPrice(), s.getManufacturer()));
                }
            }

            w.write("\n");
        }

        w.close();
    }

    public static void GenerateOrderReport(ReportType rt) throws SQLException, ClassNotFoundException, IOException
    {
        List<Order> orders = Order.GetOrders(rt);

        Writer w = null;
        
        switch (rt)
        {
            case Daily:
                w = new FileWriter(new File("Report_Order_Daily.txt"));
                break;
            case Weekly:
                w = new FileWriter(new File("Report_Order_Weekly.txt"));
                break;
            case Monthly:
                w = new FileWriter(new File("Report_Order_Monthly.txt"));
                break;
        }
        
        w.write("\t\t\t============================\n");
        w.write("\t\t\t|       ORDER REPORT       |\n");
        w.write("\t\t\t============================\n\n");

        for (Order order : orders)
        {
            double orderTotal = 0;

            w.write(order + "\n");

            w.write("---------------------------------------------------------------------------\n");
            w.write(String.format("%-10s%-15s%-20s%-10s %-10s%-10s\n", "CODE", "CATEGORY", "DESCRIPTION", "PRICE", "QUANTITY", "TOTAL"));
            w.write("---------------------------------------------------------------------------\n");

            double orderDetailTotal;

            for (OrderDetail od : order.getOrderDetails())
            {
                orderDetailTotal = od.getQuantity() * od.getPrice();
                orderTotal += orderDetailTotal;

                w.write(String.format("%s%s %6.2f\n", od, NumberFormat.getCurrencyInstance().getCurrency().getSymbol(), orderDetailTotal));
            }

            String total = String.format("%6.2f", orderTotal);

            w.write("                                                                 ----------\n");
            w.write("                                                                  R " + total + "\n");
            w.write("                                                                 ==========\n");
        }

        w.close();
    }
}
