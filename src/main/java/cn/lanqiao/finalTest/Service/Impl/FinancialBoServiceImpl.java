package cn.lanqiao.finalTest.Service.Impl;


import cn.lanqiao.finalTest.Mapper.FinancialBoMapper;
import cn.lanqiao.finalTest.Service.FinancialBoService;
import cn.lanqiao.finalTest.common.managementException;
import cn.lanqiao.finalTest.entity.dto.FinancialBoDTO;
import cn.lanqiao.finalTest.entity.pojo.FinancialBo;
import cn.lanqiao.finalTest.entity.vo.financialListVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heyutongadmin.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class FinancialBoServiceImpl extends ServiceImpl<FinancialBoMapper, FinancialBo> implements FinancialBoService {
    @Autowired
    private FinancialBoMapper financialBoMapper;


    @Override
    public financialListVo selectFinancialList(FinancialBoDTO financialBoDTO) {
        LambdaQueryWrapper<FinancialBo> financialBoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        financialBoLambdaQueryWrapper.like(financialBoDTO.getCurrentDate() != null, FinancialBo::getCurrentDate, financialBoDTO.getCurrentDate());
        financialBoLambdaQueryWrapper.eq(financialBoDTO.getType() != null, FinancialBo::getType, financialBoDTO.getType());
        Page<FinancialBo> page1 = financialBoMapper
                .selectPage(new Page<>(financialBoDTO.getCurrentNum(), financialBoDTO.getSize()), financialBoLambdaQueryWrapper);
        financialListVo financialListVo = new financialListVo();
        financialListVo.setCount(financialBoMapper.selectCount(null));
        financialListVo.setFinancialBo(page1.getRecords());
        return financialListVo;
    }

    @Override
    public FinancialBo selectById(Long id) {
        if (!StringUtils.isNotBlank(String.valueOf(id))) {
            throw new managementException(ResultCodeEnum.ID_FOR_NULL);
        }
        return super.getById(id);
    }

    @Override
    public void deleteByIds(Long[] ids) {
        boolean b = super.removeBatchByIds(Arrays.stream(ids).toList());
    }
}
