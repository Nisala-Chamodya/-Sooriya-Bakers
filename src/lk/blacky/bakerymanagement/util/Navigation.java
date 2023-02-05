package lk.blacky.bakerymanagement.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;
    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();
        switch (route){
            case LOGIN:
                window.setTitle("Login Form");
                initUI("LoginForm.fxml");
                break;
            case ADMINLOGIN:
                window.setTitle("Admin Login Form");
                initUI("AdminLoginForm.fxml");
                break;
            case CASHIERLOGIN:
                window.setTitle("Cashier Login Form");
                initUI("CashierLoginForm.fxml");
                break;
            case CHEIFCOOKLOGIN:
                window.setTitle("Cheif cook Login Form");
                initUI("CheifCookLoginForm.fxml");
                break;
            case ADMINDASHBOARD:
                window.setTitle("Admin Dashboard Form ");
                initUI("AdminDashboardForm.fxml");
                break;
            case MANAGECUSTOMER:
                window.setTitle("Manage Customer Form ");
                initUI("ManageCustomerForm.fxml");
                break;
            case MANAGEPRODUCT:
                window.setTitle("Manage Product Form ");
                initUI("ManageProductForm.fxml");
                break;
            case MANAGEEMPLOYEE:
                window.setTitle("Manage Employee Form ");
                initUI("ManageEmployeeForm.fxml");
                break;
            case MANAGESUPPLIER:
                window.setTitle("Manage Supplier Details Form ");
                initUI("ManageSupplierDetailsForm.fxml");
                break;
            case MANAGESTOCK:
                window.setTitle("Manage Stock Details Form ");
                initUI("ManageStockDetailsForm.fxml");
                break;
            case VIEWINCOMEREPORTS:
                window.setTitle("View Income Reports Form ");
                initUI("ViewIncomeReportForm.fxml");
                break;
            case VIEWMONTHLYINCOMEREPORTS:
                window.setTitle("View Monthly Income Reports Form ");
                initUI("ViewMonthlyIncomeReportForm.fxml");
                break;
            case MONTHLYPRODUCTCATEGORY:
                window.setTitle("View Monthly Product Category Selling Form ");
                initUI("ViewMonthlyProductCategorySellingForm.fxml");
                break;
            case MONTHLYPRODUCTSELLING:
                window.setTitle("View Monthly Product Selling Form ");
                initUI("ViewMonthlyProductSellingForm .fxml");
                break;
            case VIEWANNUALLYINCOMEREPORTS:
                window.setTitle("View Annually Income Report Form ");
                initUI("ViewAnnuallyIncomeReportForm.fxml");
                break;
            case ANNUALLYPRODUCTSALES:
                window.setTitle("View Annually Product Sales Report Form ");
                initUI("ViewAnnualProductSalesForm.fxml");
                break;
            case ANNUALLYSALESDATAILS:
                window.setTitle("View Annually Sales Details Form ");
                initUI("ViewAnnuallySalesDetailsForm.fxml");
                break;
            case CASHIERDASHBOARD:
                window.setTitle("CashierDashboard Form ");
                initUI("CashierDashboardForm.fxml");
                break;
            case MANAGECUSTOMERWHITHCASHEIR:
                window.setTitle("Cashier Manage Customer Form ");
                initUI("CashierManageCustomerForm.fxml");
                break;
            case MANAGEPRODUCTWITHCASHIER:
                window.setTitle("Cashier Manage Product Form ");
                initUI("CashierManageProductForm.fxml");
                break;
            case PLACEORDER:
                window.setTitle("Place Order Form ");
                initUI("PlaceOrderForm.fxml");
                break;
            case CHEIFCOOKDASHBOARD:
                window.setTitle("Chief Cook Dashboard Form ");
                initUI("ChiefCookDashboardForm.fxml");
                break;
            case MANAGEPRODUCTWITHCHEIEFCOOK:
                window.setTitle("Chief Cook Manage Product Form ");
                initUI("ChiefCookManageProductForm.fxml");
                break;
            case MANAGESUPPLIERDETAILSWITHCHEIFCOOK:
                window.setTitle("Chief Cook Manage Supplier Details Form ");
                initUI("ChiefCookManageSupplierDetailsForm.fxml");
                break;
            case MANAGESTOCKWITHCHEIFCOOK:
                window.setTitle("Chief Cook Manage Stock Details Form ");
                initUI("ChiefCookManageStockDetailsForm.fxml");
                break;
            case MANAGERECIPE:
                window.setTitle("Manage Recipe  Form ");
                initUI("ManageRecipeForm.fxml");
                break;
            case VIEWRECIPE:
                window.setTitle("View Recipe  Form ");
                initUI("ViewRecipeForm.fxml");
                break;
            case ADMINSIGNUP:
                window.setTitle("Admin Signup  Form ");
                initUI("AdminSignupForm.fxml");
                break;
            case CASHIERSIGNUP:
                window.setTitle("Cashier Signup  Form ");
                initUI("CashierSignupForm.fxml");
                break;
            case CHEIFCOOKSIGNUP:
                    window.setTitle("Cheif Cook Signup  Form ");
                initUI("CheifCookSignupForm.fxml");
                break;
            case ADMINFORGOTPASSWORD:
                window.setTitle("Admin Forgot Password  Form ");
                initUI("AdminForgotPassword.fxml");
                break;
            case CASHIERFORGOTPASSWORD:
                window.setTitle("Cashier Forgot Password  Form ");
                initUI("CashierForgotPasswordForm.fxml");
                break;
            case CHIEFCOOKFORGOTPASSWORD:
                window.setTitle("Cheif Cook Forgot Password  Form ");
                initUI("CheifCookForgotPasswordForm.fxml");
                break;
            case ADMINCUSTOMERVIEW:
                window.setTitle("Admin Customer View Form ");
                initUI("AdminCustomerViewForm.fxml");
                break;
            case ADMINPRODUCTVIEW:
                window.setTitle("Admin Product View Form ");
                initUI("AdminProductViewForm.fxml");
                break;
            case ADMINEMPLOYEEVIEW:
                window.setTitle("Admin Employee View Form ");
                initUI("AdminEmployeeViewForm.fxml");
                break;

            case ADMINSUPPLIERVIEW:
                window.setTitle("Admin Supplier View Form ");
                initUI("AdminSupplierViewForm.fxml");
                break;
            case CASHIERVIEWCUSTOMER:
                window.setTitle("Cashier View Customer Form ");
                initUI("CashierViewCustomerForm.fxml");
                break;
            case CASHIERVIEWPRODUCT:
                window.setTitle("Cashier View Product Form ");
                initUI("CashierViewProductForm.fxml");
                break;

            case MANAGEITEMS:
                window.setTitle("Manage Items Form ");
                initUI("ManageItemsForm.fxml");
                break;
            case CHEIFCOOKVIEWITEM:
                window.setTitle("View Items Form ");
                initUI("ViewItemsForm.fxml");
                break;
            case CHEIFCOOKVIEWSTOCK:
                window.setTitle("Cheif Cook View Stock Form ");
                initUI("CheifCookViewStockForm.fxml");
                break;
            case CHIEFCOOKVIEWPRODUCT:
                window.setTitle("Cheif Cook View Product Form ");
                initUI("CheifCookViewProductForm.fxml");
                break;
            case CHEIFCOOKVIEWSUPPLIER:
                window.setTitle("Cheif Cook View Supplier Form ");
                initUI("CheifCookViewSupplierForm.fxml");
                break;
            default:
                System.out.println("Invalid UI");












        }

    }

    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/blacky/bakerymanagement/view/" + location)));
    }
}
