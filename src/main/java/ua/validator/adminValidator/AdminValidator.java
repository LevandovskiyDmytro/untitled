package ua.validator.adminValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.DAO.CommodityRepository;
import ua.entities.Commodity;
import ua.validator.Validator;
import ua.validator.userValidatorImpl.UserValidationException;
import ua.validator.userValidatorImpl.UserValidationMessagess;

/**
 * Created by buriedsinner on 12/28/16.
 */

@Component("commodityValidator")
public class AdminValidator implements Validator {

    @Autowired
    private CommodityRepository commodityRepository;


    @Override
    public void validate(Object object) throws Exception {
        Commodity commodity = (Commodity) object;

        if(commodity.getModel().isEmpty()){
            throw new AdminValidationException(AdminValidationMessages.EMPTY_MODEL_FIELD);
        }
        if(commodity.getPrice() == 0){
            throw new AdminValidationException(AdminValidationMessages.EMPTY_PRICE_FIELD);
        }

    }
}
