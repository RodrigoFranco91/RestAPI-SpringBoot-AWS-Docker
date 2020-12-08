package br.com.rodrigo.converter.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.rodrigo.modelo.Pessoa;
import br.com.rodrigo.modelo.vo.PessoaVO;

public class MockPessoa {


    public Pessoa mockEntity() {
    	return mockEntity(0);
    }
    
    public PessoaVO mockVO() {
    	return mockVO(0);
    }
    
    public List<Pessoa> mockEntityList() {
        List<Pessoa> persons = new ArrayList<Pessoa>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PessoaVO> mockVOList() {
        List<PessoaVO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }
    
    private Pessoa mockEntity(Integer number) {
    	Pessoa person = new Pessoa();
    	person.setEndereco("Addres Test" + number);
        person.setNome("First Name Test" + number);
        person.setSexo(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setSobrenome("Last Name Test" + number);
        return person;
    }

    private PessoaVO mockVO(Integer number) {
    	PessoaVO person = new PessoaVO();
    	person.setEndereco("Addres Test" + number);
        person.setNome("First Name Test" + number);
        person.setSexo(((number % 2)==0) ? "Male" : "Female");
        person.setKey(number.longValue());
        person.setSobrenome("Last Name Test" + number);
        return person;
    }
}
