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
public class StationeryDescriptionSort implements Comparator<Stationery>
{
    @Override
    public int compare(Stationery o1, Stationery o2)
    {
        return o1.getDescription().compareTo(o2.getDescription());
    }
}
