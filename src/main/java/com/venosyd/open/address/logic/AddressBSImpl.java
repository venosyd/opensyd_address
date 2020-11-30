package com.venosyd.open.address.logic;

import java.util.List;

import com.venosyd.open.address.lib.AddressContants;
import com.venosyd.open.address.lib.entities.Cidade;
import com.venosyd.open.address.lib.entities.Distrito;
import com.venosyd.open.address.lib.entities.Estado;
import com.venosyd.open.address.lib.entities.Logradouro;
import com.venosyd.open.address.lib.entities.Pais;
import com.venosyd.open.address.lib.entities.TipoLogradouro;
import com.venosyd.open.commons.log.Debuggable;
import com.venosyd.open.commons.services.interfaces.Repository;

import org.bson.Document;

/**
 * @author sergio lisan <sels@venosyd.com>
 */
public class AddressBSImpl implements AddressBS, Debuggable {

    @Override
    public void addNewPlace(String paisName, String estadoName, String cidadeName, String distritoName,
            String tipoLogradouroName, String logradouroName, String cep) {
        try {
            var repository = new Repository(AddressContants.DB);

            var pais = repository.get(Pais.class, "nome", paisName);
            if (pais == null) {
                pais = new Pais();
                pais.setCodigo(-1);
                pais.setNome(paisName);

                repository.save(pais);
            }

            var estadoSearch = new Document();
            estadoSearch.put("paisID", pais.getId());
            estadoSearch.put("nome", estadoName);

            var estado = repository.get(Estado.class, estadoSearch);
            if (estado == null) {
                estado = new Estado();
                estado.setNome(estadoName);
                estado.setPaisID(pais.getId());
                estado.setSigla(estadoName.substring(0, 2));

                repository.save(estado);
            }

            var cidadeSearch = new Document();
            cidadeSearch.put("estadoID", estado.getId());
            cidadeSearch.put("nome", cidadeName);

            var cidade = repository.get(Cidade.class, cidadeSearch);
            if (cidade == null) {
                cidade = new Cidade();
                cidade.setNome(cidadeName);
                cidade.setEstadoID(estado.getId());

                repository.save(cidade);
            }

            var distritoSearch = new Document();
            distritoSearch.put("cidadeID", cidade.getId());
            distritoSearch.put("nome", distritoName);

            var distrito = repository.get(Distrito.class, distritoSearch);
            if (distrito == null) {
                distrito = new Distrito();
                distrito.setNome(distritoName);
                distrito.setCidadeID(cidade.getId());

                repository.save(distrito);
            }

            var tipoLogradouro = repository.get(TipoLogradouro.class, "descricao", tipoLogradouroName);
            if (tipoLogradouro == null) {
                tipoLogradouro = new TipoLogradouro();
                tipoLogradouro.setDescricao(tipoLogradouroName);

                repository.save(tipoLogradouro);
            }

            var logradouro = new Logradouro();
            logradouro.setNome(logradouroName);
            logradouro.setDistritoID(distrito.getId());
            logradouro.setTipoLogradouroID(tipoLogradouro.getId());
            logradouro.setCep(cep.replace("\\D+", "").replace(" ", ""));

            repository.save(logradouro);

        } catch (Exception e) {
            err.exception("BUSINESS ADD PLACE", e);
        }
    }

    @Override
    public void updatePlace(String cep, String newName) {
        try {
            var repository = new Repository(AddressContants.DB);

            cep = cep.replace("\\D+", "").replace(" ", "");

            var logradouro = repository.get(Logradouro.class, "cep", cep);
            logradouro.setNome(newName);

            repository.save(logradouro);

        } catch (Exception e) {
            err.exception("BUSINESS UPDATEPLACE", e);
        }
    }

    @Override
    public Logradouro getLogradouro(String cep) {
        try {
            var repository = new Repository(AddressContants.DB);

            cep = cep.replace("\\D+", "").replace(" ", "");
            return repository.<Logradouro>get(Logradouro.class, "cep", cep);

        } catch (Exception e) {
            err.exception("BUSINESS GETPLACE", e);
        }

        return null;
    }

    @Override
    public List<Estado> getStates(String paisName) {
        try {
            var repository = new Repository(AddressContants.DB);

            var pais = repository.get(TipoLogradouro.class, "nome", paisName);
            return repository.<Estado>list(Estado.class, "paisID", pais.getId());

        } catch (Exception e) {
            err.exception("BUSINESS LIST STATES", e);
        }

        return null;
    }

    @Override
    public List<Cidade> getCities(String estadoName) {
        try {
            var repository = new Repository(AddressContants.DB);

            var estado = repository.get(Estado.class, "nome", estadoName);
            return repository.<Cidade>list(Cidade.class, "estadoID", estado.getId());

        } catch (Exception e) {
            err.exception("BUSINESS LIST CITIES", e);
        }

        return null;
    }

    @Override
    public List<Distrito> getDistricts(String cidadeName) {
        try {
            var repository = new Repository(AddressContants.DB);

            var cidade = repository.get(Cidade.class, "nome", cidadeName);
            return repository.<Distrito>list(Distrito.class, "cidadeID", cidade.getId());
        } catch (Exception e) {
            err.exception("BUSINESS LIST DISTRICTS", e);

            return null;
        }
    }

}
