package lk.blacky.bakerymanagement.dao;

import lk.blacky.bakerymanagement.dao.custom.SuperDAO;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
     CUSTOMER,EMPLOYEE,ITEM,PRODUCT,RECIPE,SUPPLIER
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {


            case CUSTOMER:
                return new CustomerDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case PRODUCT:
                return new ProductDAOImpl();
            case RECIPE:
                return new RecipeDAOImpl();
            case SUPPLIER:
                return new SupplierDAOImpl();

            default:
                return null;
        }
    }
}
