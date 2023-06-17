package org.example.services;

import org.example.entities.Provider;
import org.example.utils.ConnectionFactory;
import org.example.repositories.ProviderRepository;

public class ProviderService {
    private final ProviderRepository providerRepository = new ProviderRepository(new ConnectionFactory());

    public Provider getProviderById(Long id) {
        return providerRepository.get(id);
    }

    public boolean saveProvider(Provider provider) {
        return providerRepository.save(provider);
    }
}
