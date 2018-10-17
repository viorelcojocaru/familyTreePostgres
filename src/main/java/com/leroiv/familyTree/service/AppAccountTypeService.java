package com.leroiv.familyTree.service;

import com.leroiv.familyTree.domain.AppAccount;
import com.leroiv.familyTree.domain.AppAccountType;
import com.leroiv.familyTree.repository.AppAccountTypeRepository;
import com.leroiv.familyTree.service.intf.AppAccountTypeServiceIntf;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppAccountTypeService implements AppAccountTypeServiceIntf {

    private final AppAccountTypeRepository repo;

    @Override
    public List<AppAccountType> listAll() {
        return repo.findAll();
    }

    @Override
    public AppAccountType getById(Long id) {
        return repo.getOne(id);
    }

    @Override
    public AppAccountType saveOrUpdate(AppAccountType appAccountType) {
        return repo.save(appAccountType);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }


}
