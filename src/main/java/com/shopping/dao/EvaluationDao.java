package com.shopping.dao;

import com.shopping.entity.Evaluation;
//import com.sun.org.apache.xml.internal.serialize.LineSeparator;

import java.util.List;

/**
 * Created by 14437 on 2017/3/7.
 */
public interface EvaluationDao {
    Evaluation getEvaluation(int userId,int productId,String time);

    void addEvaluation(Evaluation evaluation);

    boolean deleteEvaluation(int userId,int productId,String time);

    boolean updateEvaluation(Evaluation evaluation);

    List<Evaluation> getProductEvaluation(int productId);

    boolean deleteEvaluationByUser(int userId);

    boolean deleteEvaluationByProduct(int productId);
}
