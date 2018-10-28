/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.util.Comparator;

/**
 *
 * @author Nicky
 */
public class StationeryStockSort implements Comparator<Stationery>
{
    @Override
    public int compare(Stationery o1, Stationery o2)
    {
        if (o1.getStock() == o2.getStock())
        {
            return 0;
        }
        else if (o1.getStock() > o2.getStock())
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }    
}
