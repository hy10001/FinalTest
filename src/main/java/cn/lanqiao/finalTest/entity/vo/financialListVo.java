package cn.lanqiao.finalTest.entity.vo;

import cn.lanqiao.finalTest.entity.pojo.FinancialBo;

import java.util.List;

    public class financialListVo {
        private Long count;
        private List<FinancialBo> financialBo;

        public Long getCount() {
            return count;
        }

        public void setCount(Long count) {
            this.count = count;
        }

        public List<FinancialBo> getFinancialBo() {
            return financialBo;
        }

        public void setFinancialBo(List<FinancialBo> financialBo) {
            this.financialBo = financialBo;
        }
    }
