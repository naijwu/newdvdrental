package com.mjtoolbox.newdvdrental.actor;

import org.springframework.data.repository.PagingAndSortingRepository;

// extends pagingAndSorting repository; entity type and param (id)
public interface ActorRepository extends PagingAndSortingRepository<Actor, Long> {
}
