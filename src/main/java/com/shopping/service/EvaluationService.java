package com.shopping.service;

import com.shopping.entity.Evaluation;

import java.util.List;

/**
 * Created by 14437 on 2017/3/7.
 */
public interface EvaluationService {
    Evaluation getEvaluation(int userId, int productId, String time);

    void addEvaluation(Evaluation evaluation);

    boolean deleteEvaluation(int userId,int productId,String time);

    boolean updateEvaluation(Evaluation evaluation);

    List<Evaluation> getProductEvaluation(int productId);
}
