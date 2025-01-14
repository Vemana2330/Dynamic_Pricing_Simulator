/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class ProductsReport {

    ArrayList<ProductSummary> productsummarylist;

    public ProductsReport() {
        productsummarylist = new ArrayList();
    }

    public void addProductSummary(ProductSummary ps) {

        productsummarylist.add(ps);
    }

    public int getPricePerformance() {
        int sum = 0;
        for (ProductSummary ps : productsummarylist) {
            System.out.println("Product: " + ps.getProductName() + " Price Performance: " + ps.getProductPricePerformance());
            sum = sum + ps.getProductPricePerformance();
        }
        return sum;
    }

    public ProductSummary getTopProductAboveTarget() {
        ProductSummary currenttopproduct = null;

        for (ProductSummary ps : productsummarylist) {
            if (currenttopproduct == null) {
                currenttopproduct = ps; // initial step 
            } else if (ps.getNumberAboveTarget() > currenttopproduct.getNumberAboveTarget()) {
                currenttopproduct = ps; //we have a new higher total
            }

        }
        return currenttopproduct;
    }

    public ArrayList<ProductSummary> getProductSummaryList() {
        return productsummarylist;
    }

    public ArrayList<ProductSummary> getProductsAlwaysAboveTarget() {
        ArrayList<ProductSummary> productsalwaysabovetarget = new ArrayList(); //temp array list

        for (ProductSummary ps : productsummarylist) {
            if (ps.isProductAlwaysAboveTarget() == true) {
                productsalwaysabovetarget.add(ps);
            }
        }

        return productsalwaysabovetarget;
    }

}
