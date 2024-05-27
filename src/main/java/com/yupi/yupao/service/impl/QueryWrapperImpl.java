package com.yupi.yupao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.yupao.mapper.TeamMapper;
import com.yupi.yupao.model.domain.Team;
import com.yupi.yupao.model.request.TeamAddRequest;
import com.yupi.yupao.model.request.TeamQuitRequest;
import com.yupi.yupao.model.request.TeamUpdateRequest;
import com.yupi.yupao.model.vo.TeamUserVO;
import com.yupi.yupao.service.QueryWrapperInter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class QueryWrapperImpl extends ServiceImpl<TeamMapper, Team> implements QueryWrapperInter {

    @Resource
    private TeamMapper teamMapper;
    @Override
    public long addTest(Team team) {

        boolean b = this.save(team);
        if (!b){
            System.out.println("添加失败");
        }
        QueryWrapper<Team> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",team.getName());
        List<Team> list = this.list(queryWrapper);
        return list.get(0).getId();
    }

    @Override
    public boolean deleteTest(TeamQuitRequest teamQuitRequest) {
        QueryWrapper<Team> queryWrapper = new QueryWrapper<>();
         queryWrapper.eq("id", teamQuitRequest.getTeamId());
//        boolean b = this.removeById(teamQuitRequest.getTeamId());
        int i = teamMapper.deleteById(teamQuitRequest.getTeamId());
        System.out.println(i);
//        boolean remove = this.remove(queryWrapper);
//        System.out.println(delete);
//        System.out.println(remove);
        return true;
    }

    @Override
    public TeamUserVO updateTest(TeamUpdateRequest teamUpdateRequest) {

        return null;
    }

    @Override
    public List<TeamUserVO> selectTest(long teamQuery) {
        QueryWrapper<Team> teamQueryWrapper = new QueryWrapper<>();
        teamQueryWrapper.eq("id",teamQuery);
        List<Team> list = this.list(teamQueryWrapper);
        TeamUserVO teamUserVO = new TeamUserVO();
        List<TeamUserVO>  teamUserVOList = new ArrayList<>();
        for (Team team: list){
            BeanUtils.copyProperties(team,teamUserVO);
            teamUserVOList.add(teamUserVO);
        }
        return teamUserVOList;

    }
}
