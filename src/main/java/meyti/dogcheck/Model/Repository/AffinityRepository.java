package meyti.dogcheck.Model.Repository;

import meyti.dogcheck.Model.Entity.Affinity;
import meyti.dogcheck.Model.Entity.Key.AffinityKey;
import org.springframework.data.repository.CrudRepository;

public interface AffinityRepository extends CrudRepository<Affinity, AffinityKey> {
    Affinity findOneBySenderIdAndReceiverId(long senderId, long receiverId);
}
