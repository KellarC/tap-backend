import com.rhodes.tapbackend.models.ScoreboardDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ScoreboardRepository extends JpaRepository<ScoreboardDTO, Long> {
    List<ScoreboardDTO> findTopScoresOrderByScoreDesc(int limit);
}

