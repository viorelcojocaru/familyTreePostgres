package com.leroiv.familyTree.BC;

import com.leroiv.familyTree.constants.Genders;
import com.leroiv.familyTree.domain.AppAccount;
import com.leroiv.familyTree.domain.AppAccountType;
import com.leroiv.familyTree.domain.Person;
import com.leroiv.familyTree.domain.Relation;
import com.leroiv.familyTree.service.AppAccountService;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

//@NoArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AccountBC {
    private static AccountBC instance;

    private AccountBC() {
    }

    public synchronized static AccountBC getInstance() {
        if (instance != null)
            return new AccountBC();
        return instance;
    }

    public AppAccount createAppAccount(Person person, AppAccountType appAccountType) {
        AppAccount appAccount;
        appAccount = AppAccount.builder().person(person).name("AppAccount_" + appAccountType.getName()).type(appAccountType).build();
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

}
