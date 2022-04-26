package kr.co.seculink.web.controller.intf;

import kr.co.seculink.domain.RtnMsg;
import kr.co.seculink.util.GEUtil;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class GramController
{
    @Resource(name = "readerDaoDif")
    private SqlSessionTemplate dao;

    @PostMapping("/intf/gramList/searchGramList.ab")
    public RtnMsg searchGramList(@RequestBody HashMap<String, String> params)
    {
        RtnMsg<Map<String, Object>> vo = new RtnMsg<>();
        Map<String, Object> rtnMap = new HashMap<>();

        List<Map<String, String>> result = dao.selectList("intf.gramHist.searchGramList", params);

        if ( !GEUtil.isEmpty(params.get("paging")) ) {
            params.put("paging", "N");
            vo.setTotalCount(dao.selectList("intf.gramHist.searchGramList", params).size());
        }

        rtnMap.put("result", result);
        vo.setRtnData(rtnMap, params);

        return vo;
    }
}
