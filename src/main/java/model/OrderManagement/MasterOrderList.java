/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.OrderManagement;

import java.util.ArrayList;

import model.CustomerManagement.CustomerProfile;
import model.MarketingManagement.MarketingPersonProfile;
import model.SalesManagement.SalesPersonProfile;

/**
 *
 * @author kal bugrara
 */
public class MasterOrderList {

    ArrayList<Order> orders;
    MasterOrderReport masterorderreport;

    public MasterOrderList() {
        orders = new ArrayList();

    }

    public Order newOrder(CustomerProfile cp) {
        Order o = new Order(cp);
        orders.add(o);
        return o;

    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public MasterOrderList getSalesPersonOrderList(SalesPersonProfile salesPersonProfile) {
        MasterOrderList salesPersonOrderList = new MasterOrderList();
        for (Order order : orders) {
            if (order.getSalesperson() == salesPersonProfile) {
                salesPersonOrderList.orders.add(order);
            }
        }
        return salesPersonOrderList;
    }

    public Order newOrder(CustomerProfile cp, SalesPersonProfile spp) {
        Order o = new Order(cp, spp);
        orders.add(o);
        return o;

    }

    public MasterOrderReport generateMasterOrderReport() {
        masterorderreport = new MasterOrderReport();

        return masterorderreport;

    }

    public int getSalesVolume() {

        int sum = 0;
        for (Order order : orders) {
            sum = sum + order.getOrderTotal();
        }
        return sum;
    }

}
