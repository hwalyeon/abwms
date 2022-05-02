package kr.co.seculink.web.service.stat.hc;

import kr.co.seculink.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("avalActStssService")
public class AvalActStssServiceImpl implements AvalActStssService
{
    @Resource(name="sqlSessionTemplate")
    private SqlSessionTemplate dao;

    public List<Map<String, Object>> searchAvalActStssList(Map<String, String> params) throws BizException
    {
        List<Map<String, Object>> result = dao.selectList("stat.hc.avalActStss.searchAvalActStssList", params);

        List<Map<String, Object>> newResult = new ArrayList<Map<String, Object>>();

        if(result != null && result.size() > 0){
            Map<String, Object> newInfo          = new HashMap<String, Object>();
            Map<String, Object> newInfoCalCsumQty = new HashMap<>();
            String actDivCd = null;
            String actDivNm = null;

            for (Map<String, Object> info : result){
                if(actDivCd != null && !actDivCd.equals(info.get("foodNm"))){
                    newInfo.put("actDivCd", actDivCd);
                    newInfo.put("actDivNm", actDivNm);
                    newInfo.put("divCd", "01");
                    newInfo.put("divNm", "운동시간(분)");
                    newInfoCalCsumQty.put("actDivCd", actDivCd);
                    newInfoCalCsumQty.put("actDivNm", actDivNm);
                    newInfoCalCsumQty.put("divCd", "02");
                    newInfoCalCsumQty.put("divNm", "칼로리소모량(㎉)");
                    newResult.add(newInfo);
                    newResult.add(newInfoCalCsumQty);
                    newInfo = new HashMap<String, Object>();
                    newInfoCalCsumQty = new HashMap<String, Object>();

                }
                newInfo.put(info.get("stndDt").toString(), info.get("avgActTcntMcnt").toString());
                newInfoCalCsumQty.put(info.get("stndDt").toString(), info.get("avgCalCsumQty").toString());

                actDivCd = info.get("actDivCd").toString();
                actDivNm = info.get("actDivNm").toString();
            }
            newInfo.put("actDivCd", actDivCd);
            newInfo.put("actDivNm", actDivNm);
            newInfo.put("divCd", "01");
            newInfo.put("divNm", "운동시간(분)");
            newInfoCalCsumQty.put("actDivCd", actDivCd);
            newInfoCalCsumQty.put("actDivNm", actDivNm);
            newInfoCalCsumQty.put("divCd", "02");
            newInfoCalCsumQty.put("divNm", "칼로리소모량(㎉)");
            newResult.add(newInfo);
            newResult.add(newInfoCalCsumQty);
        }
        return newResult;
    }
}

