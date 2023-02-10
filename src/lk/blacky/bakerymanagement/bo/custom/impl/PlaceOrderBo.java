package lk.blacky.bakerymanagement.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.blacky.bakerymanagement.dto.OrderDTO;
import lk.blacky.bakerymanagement.view.tm.CartTm;

public interface PlaceOrderBo extends SuperBo{
    public boolean saveOrder(OrderDTO dto, ObservableList<CartTm> obList);

}
