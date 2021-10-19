package feelmusicbackend.demo.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TransactionRepository {
    public Integer getLastInsertId();
}
