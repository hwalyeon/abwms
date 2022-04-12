package kr.co.seculink.web.service.stat.dgem;

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
@Service("dzoneStssService")
public class DzoneStssServiceImpl implements DzoneStssService {
    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate dao;

    public List<Map<String, Object>> searchDzoneStssList(Map<String, String> params) throws BizException {
        List<Map<String, Object>> result = dao.selectList("stat.dgem.dzoneStss.searchDzoneStssList", params);

        List<Map<String, Object>> newResult = new ArrayList<Map<String, Object>>();

        if (result != null && result.size() > 0) {
            Map<String, Object> newInfo = new HashMap<String, Object>();
            Map<String, Object> newInfoCalCsumQty = new HashMap<>();

            for (Map<String, Object> info : result) {
                newInfo.put(info.get("stndDt").toString(), info.get("occrCnt").toString());
                newInfoCalCsumQty.put(info.get("stndDt").toString(), info.get("stdtCnt").toString());
            }

            newInfo.put("divCd", "발생건수");
            newInfoCalCsumQty.put("divCd", "발생학생수");
            newResult.add(newInfo);
            newResult.add(newInfoCalCsumQty);
        }
        return newResult;
    }
}

