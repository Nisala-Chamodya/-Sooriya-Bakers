package lk.blacky.bakerymanagement.bo.custom.impl;



public class BOFactory {
    private static BOFactory boFactory;


    private BOFactory(){}

    public static BOFactory getBoFactory(){return (boFactory==null)? boFactory=new BOFactory() : boFactory;}

    public enum BoTypes{
        CUSTOMER,EMPLOYEE,ITEM,PRODUCT,RECIPE,SUPPLIER,PLACEORDERBO
    }

    //Object creation logic for BO objects

    public SuperBo getBo(BoTypes types){
        switch (types){
            case CUSTOMER:
                return new CustomerBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PRODUCT:
                return new ProductBOImpl();
            case RECIPE:
                return new RecipeBOImpl();
            case SUPPLIER:
                return new SupplierBoImpl();
            case PLACEORDERBO:
                return new PlaceOrderBOImpl();
            default:
                return null;

        }

    }



}
