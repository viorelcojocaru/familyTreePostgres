package com.leroiv.familyTree.BC;

import com.leroiv.familyTree.constants.AppAccountTypes;
import com.leroiv.familyTree.constants.Genders;
import com.leroiv.familyTree.domain.AppAccount;
import com.leroiv.familyTree.domain.AppAccountType;
import com.leroiv.familyTree.domain.Person;
import com.leroiv.familyTree.domain.Relation;
import com.leroiv.familyTree.service.AppAccountService;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service()
public class AccountBC {
//    private static AccountBC instance;
//
//    private AccountBC() {
//    }
//
//    public synchronized static AccountBC getInstance() {
//        if (instance != null)
//            return new AccountBC();
//        return instance;
//    }

    public AppAccount createAppAccount(Person person, AppAccountType appAccountType) {
        AppAccount appAccount;
        appAccount = AppAccount.builder().person(person).name("AppAccount_"+person.getFirstName()+"_"+person.getLastName() +"_"+ appAccountType.getName()).type(appAccountType).build();
        return appAccount;
    }

    /*
     *from = parent, male, ;
     *  to = cild, female
     */
    public void createRelation(AppAccount appAccountFrom, AppAccount appAccountTo) throws Exception {
        if (appAccountFrom != null && appAccountTo != null) {
            Relation relation = new Relation();
            relation.setFromAppAccountId(appAccountFrom);
            relation.setToAppAccountId(appAccountTo);
        }else
            throw new Exception("relation are null");
    }
    public Map<String ,AppAccount> getFromToAppAccountMap(AppAccount from, AppAccount to, long typeId){
        Map<String ,AppAccount> map=new HashMap<>();
        switch ((int)typeId){
            case (int)AppAccountTypes.CILD:
                ;
            break;
            case (int)AppAccountTypes.PARTNER :
                ;
            break;
            default: ;
        }
        return map;
    }


}
