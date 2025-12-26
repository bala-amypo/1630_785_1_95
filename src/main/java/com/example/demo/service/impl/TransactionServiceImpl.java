package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.TransactionLog;
import com.example.demo.model.User;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionLogRepository transactionRepo;
    private final UserRepository userRepository;

    @Override
    public TransactionLog addTransaction(Long userId, TransactionLog log) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found"));
        log.setUser(user);
        log.validate();
        return transactionRepo.save(log);
    }

    @Override
    public List<TransactionLog> getUserTransactions(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found"));
        return transactionRepo.findByUser(user);
    }

    @Override
    public List<TransactionLog> getTransactionsByMonth(Long userId, int month, int year) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found"));
        YearMonth ym = YearMonth.of(year, month);
        return transactionRepo.findByUserAndTransactionDateBetween(
                user, ym.atDay(1), ym.atEndOfMonth());
    }
}





// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;   
// import com.example.demo.model.TransactionLog;
// import com.example.demo.repository.TransactionLogRepository;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.service.TransactionService;                

// @Service
// public class TransactionPlanServiceImpl implements TransactionService{

//     @Autowired TransactionLogRepository used;
//     @Override
//     public TransactionLog postData2(TransactionLog use){
//         return used.save(use);  
//     }
//     @Override
//     public List<TransactionLog>getAllData2(){
//         return used.findAll();
//     }
//     @Override
//     public String DeleteData2(Long id){
//         used.deleteById(id);
//         return "Deleted successfully";
//     }
//     @Override
//     public TransactionLog getData2(Long id){
//     return used.findById(id).orElse(null);
//     }
//     @Override
//     public TransactionLog updateData2(Long id,TransactionLog entity){
//         if(used.existsById(id)){
//             entity.setId(id);
//             return used.save(entity);
//         } 
//         return null;
//     }
// }