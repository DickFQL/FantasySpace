package com.yupi.yupao.service;


import com.yupi.yupao.model.domain.Team;
import com.yupi.yupao.model.request.TeamAddRequest;
import com.yupi.yupao.model.request.TeamQuitRequest;
import com.yupi.yupao.model.request.TeamUpdateRequest;
import com.yupi.yupao.model.vo.TeamUserVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class QueryWrapperTestInterTest {
    @Resource
    private QueryWrapperInter queryWrapperInter;
    @Test
    void listTest(){
        //增加
//        queryWrapperInter.updateTest()
        //查询
        List<TeamUserVO> teamUserVOList = queryWrapperInter.selectTest(2);
        TeamUserVO teamUserVO = teamUserVOList.get(0);
        System.out.println(teamUserVO);
    }
    @Test
    void addTest(){
        Team team = new Team();
        team.setUserId(8L);
        team.setName("test");
        team.setStatus(0);
        team.setId(null);

            long teamUserVO = queryWrapperInter.addTest(team);
            System.out.println(teamUserVO);




    }
    @Test
    void deleteTest(){
        Team team = new Team();
        TeamQuitRequest teamQuitRequest = new TeamQuitRequest();

        teamQuitRequest.setTeamId(10L);
        boolean b = queryWrapperInter.deleteTest(teamQuitRequest);

//        System.out.println(teamUserVO);

    }
}
