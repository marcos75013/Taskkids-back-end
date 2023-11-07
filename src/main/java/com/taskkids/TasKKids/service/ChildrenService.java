//package com.taskkids.TasKKids.service;
//
//import com.taskkids.TasKKids.entity.ChildrenEntity;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import com.taskkids.TasKKids.repository.ChildrenRepository;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class ChildrenService {
//
//    private final ChildrenRepository childrenRepository;
//
//   public List<ChildrenEntity> getAll() {
//       return childrenRepository.findAll();
//   }
//
//    public <children> children getById(Long id) {
//        return null;
//    }


//    public Object getById(Long id) {
//       return childrenRepository.findById();
//    }
//}

package com.taskkids.TasKKids.service;

import com.taskkids.TasKKids.entity.ChildrenEntity;
import com.taskkids.TasKKids.entity.ParentsEntity;
import com.taskkids.TasKKids.entity.TasksEntity;
import com.taskkids.TasKKids.repository.ChildrenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChildrenService {

    private final ChildrenRepository childrenRepository;

}


