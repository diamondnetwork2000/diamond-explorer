package io.diamondnetwork.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.diamondnetwork.model.Validator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ValidatorMapper extends BaseMapper<Validator> {
    Validator getValidatorByProposerAddress(@Param("proposerAddress") String proposerAddress);

    Validator getValidatorByConsensusPubkey(@Param("consensusPubkey") String consensusPubkey);
}
