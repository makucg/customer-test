package com.cuatroochenta.ticketing.service;

import com.cuatroochenta.ticketing.domain.Language;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Language}.
 */
public interface LanguageService {
    /**
     * Save a language.
     *
     * @param language the entity to save.
     * @return the persisted entity.
     */
    Language save(Language language);

    /**
     * Updates a language.
     *
     * @param language the entity to update.
     * @return the persisted entity.
     */
    Language update(Language language);

    /**
     * Partially updates a language.
     *
     * @param language the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Language> partialUpdate(Language language);

    /**
     * Get all the languages.
     *
     * @return the list of entities.
     */
    List<Language> findAll();

    /**
     * Get the "id" language.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Language> findOne(Long id);

    /**
     * Delete the "id" language.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
