package com.csye7200.application.repository;

import com.csye7200.application.objects.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends CrudRepository<Song,Long> {
}
