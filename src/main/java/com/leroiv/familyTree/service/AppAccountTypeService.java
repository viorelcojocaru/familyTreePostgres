package com.leroiv.familyTree.service;

import com.leroiv.familyTree.domain.AppAccountType;
import com.leroiv.familyTree.repository.AppAccountTypeRepository;
import com.leroiv.familyTree.service.intf.AppAccountTypeServiceIntf;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppAccountTypeService implements AppAccountTypeServiceIntf {

    private final AppAccountTypeRepository appAccountTypeRepository;

    @Override
    public List<AppAccountType> listAll() {
        return appAccountTypeRepository.findAll();
    }

    @Override
    public boolean existEntry(Long id) {
        return appAccountTypeRepository.existsById(id);
    }

    @Override
    public AppAccountType getById(Long id) {
        return appAccountTypeRepository.getOne(id);
    }

    @Override
    public AppAccountType saveOrUpdate(AppAccountType appAccountType) {
        return appAccountTypeRepository.save(appAccountType);
    }

    @Override
    public void delete(Long id) {
        appAccountTypeRepository.deleteById(id);
    }


}
