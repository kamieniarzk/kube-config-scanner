package com.kcs.score.persistence.document;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
class MongoKubeScoreRepository implements KubeScoreRepository {

  private final KubeScoreRunDocumentRepository documentRepository;

  @Override
  public String save(KubeScoreRunCreate runCreate) {
    return documentRepository.save(DocumentFactory.create(runCreate)).id();
  }

  @Override
  public List<KubeScoreRunDto> getByNamespace(String namespace) {
    return documentRepository.findByNamespace(namespace).stream()
        .map(KubeScoreRunDocument::toDto)
        .toList();
  }
}