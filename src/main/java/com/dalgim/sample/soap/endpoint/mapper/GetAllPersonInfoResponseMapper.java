package com.dalgim.sample.soap.endpoint.mapper;

import com.dalgim.namespace.personservice.general.GetAllPersonInfoResponse;
import com.dalgim.sample.soap.domain.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Collection;

/**
 * Created by dalgim on 01.04.2017.
 */
@Component
@RequiredArgsConstructor
public class GetAllPersonInfoResponseMapper implements EndpointObjectOutMapper<GetAllPersonInfoResponse, Collection<Person>> {

    private final GetPersonInfoResponseMapper getPersonInfoResponseMapper;

    @Override
    public GetAllPersonInfoResponse map(Collection<Person> domainModelList) {
        if (domainModelList == null || domainModelList.isEmpty()) {
            return null;
        }

        GetAllPersonInfoResponse getAllPersonInfoResponse = new GetAllPersonInfoResponse();
        domainModelList.stream()
                .map(getPersonInfoResponseMapper::map)
                .forEach(getPersonInfoResponse -> getAllPersonInfoResponse.getPersons()
                        .add(getPersonInfoResponse.getPersonInfo()));
        return getAllPersonInfoResponse;
    }
}
