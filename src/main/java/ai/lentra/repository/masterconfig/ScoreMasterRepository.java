package ai.lentra.repository.masterconfig;


import ai.lentra.modal.scoreconfig.ScoreMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreMasterRepository extends JpaRepository<ScoreMaster,Long> {


   // @Query(value = "update score_master m set m. where m.sc_name=: ",nativeQuery = true)
   // public void updateScoreMinMaxVal(@Param("") String scoreName,@Param("") Integer scoreValue,@Param("") Integer minRange,@Param("") Integer maxRange);

    @Query(value = "update score_master m set m.scoreValue =:scoreValue, m.range_indicator=:rangeIndicator where m.sc_name=:scoreName ",nativeQuery = true)
    public void updateScore(@Param("scoreName")String scoreName,@Param("scoreValue") Integer scoreValue,@Param("rangeIndicator")Boolean rangeIndicator);
}
