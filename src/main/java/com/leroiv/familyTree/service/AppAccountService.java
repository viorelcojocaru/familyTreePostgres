package com.leroiv.familyTree.service;

import com.leroiv.familyTree.domain.AppAccount;
import com.leroiv.familyTree.repository.AppAccountRepository;
import com.leroiv.familyTree.service.intf.AppAccountServiceIntf;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppAccountService implements AppAccountServiceIntf {

    private final AppAccountRepository repo;

    @Override
    public List<AppAccount> listAll() {
        return repo.findAll();
    }

    @Override
    public AppAccount getById(Long id) {
        return repo.getOne(id);
    }

    @Override
    public AppAccount saveOrUpdate(AppAccount appAccount) {
        return repo.save(appAccount);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    public AppAccount getAppAccountBy(long personId, long typeId){
        return repo.getAppAccountBy(personId, typeId);
    }
}
