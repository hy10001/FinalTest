package cn.lanqiao.finalTest.Controller;


import cn.lanqiao.finalTest.Service.FinancialBoService;
import cn.lanqiao.finalTest.common.Result;
import cn.lanqiao.finalTest.common.managementException;
import cn.lanqiao.finalTest.entity.dto.FinancialBoDTO;
import cn.lanqiao.finalTest.entity.pojo.FinancialBo;
import cn.lanqiao.finalTest.entity.vo.financialListVo;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.heyutongadmin.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;

@RestController
@RequestMapping("/financial")
@CrossOrigin
public class financialBoController {
    @Autowired
    private FinancialBoService financialBoService;

    @PostMapping("/select")
    public Result<financialListVo> select(@RequestBody FinancialBoDTO financialBoDTO) {
        System.err.println(financialBoDTO);
        financialListVo list = financialBoService.selectFinancialList(financialBoDTO);
        return Result.ok(list);
    }

    @PostMapping("/insertAndUpdate")
    public Result insert(@RequestBody FinancialBo financialBo) {
        financialBo.setCurrentDate(LocalDate.now());
        boolean b = financialBoService.saveOrUpdate(financialBo);
        return b ? Result.ok() : Result.fail();
    }

    @GetMapping("/{id}")
    public Result<FinancialBo> selectById(@PathVariable Long id) {
        FinancialBo Bo = financialBoService.selectById(id);
        return Result.ok(Bo);
    }

    @DeleteMapping("/{ids}")
    public Result deleteIds(@PathVariable Long[] ids) {
        if (CollectionUtils.isEmpty(Arrays.stream(ids).toList())) {
            throw new managementException(ResultCodeEnum.ID_FOR_NULL);
        }
        financialBoService.deleteByIds(ids);
        return Result.ok();
    }
}

