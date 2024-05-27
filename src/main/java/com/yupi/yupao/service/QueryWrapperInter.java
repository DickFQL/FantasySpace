package com.yupi.yupao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yupao.model.domain.Team;
import com.yupi.yupao.model.request.TeamAddRequest;
import com.yupi.yupao.model.request.TeamQuitRequest;
import com.yupi.yupao.model.request.TeamUpdateRequest;
import com.yupi.yupao.model.vo.TeamUserVO;

import java.util.List;

public interface QueryWrapperInter extends IService<Team> {

    long addTest(Team team);

    boolean deleteTest(TeamQuitRequest teamQuitRequest);

    TeamUserVO updateTest(TeamUpdateRequest teamUpdateRequest);


    List<TeamUserVO> selectTest(long teamQuery);
}