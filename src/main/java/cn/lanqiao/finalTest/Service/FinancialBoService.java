package cn.lanqiao.finalTest.Service;


import cn.lanqiao.finalTest.entity.dto.FinancialBoDTO;
import cn.lanqiao.finalTest.entity.pojo.FinancialBo;
import cn.lanqiao.finalTest.entity.vo.financialListVo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface FinancialBoService extends IService<FinancialBo> {
    financialListVo selectFinancialList(FinancialBoDTO financialBoDTO);

    FinancialBo selectById(Long id);

    void deleteByIds(Long[] ids);
}
