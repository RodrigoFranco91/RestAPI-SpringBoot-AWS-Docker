package br.com.rodrigo.converter.mocks;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.rodrigo.converter.DozerConverter;
import br.com.rodrigo.modelo.Pessoa;
import br.com.rodrigo.modelo.vo.PessoaVO;

public class DozerConverterTest {
	 MockPessoa inputObject;

	    @Before
	    public void setUp() {
	        inputObject = new MockPessoa();
	    }

	    @Test
	    public void parseEntityToVOTest() {
	        PessoaVO output = DozerConverter.parseObject(inputObject.mockEntity(), PessoaVO.class);
	        Assert.assertEquals(Long.valueOf(0L), output.getId());
	        Assert.assertEquals("First Name Test0", output.getNome());
	        Assert.assertEquals("Last Name Test0", output.getSobrenome());
	        Assert.assertEquals("Addres Test0", output.getEndereco());
	        Assert.assertEquals("Male", output.getSexo());
	    }

	    @Test
	    public void parseEntityListToVOListTest() {
	        List<PessoaVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), PessoaVO.class);
	        PessoaVO outputZero = outputList.get(0);
	        
	        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
	        Assert.assertEquals("First Name Test0", outputZero.getNome());
	        Assert.assertEquals("Last Name Test0", outputZero.getSobrenome());
	        Assert.assertEquals("Addres Test0", outputZero.getEndereco());
	        Assert.assertEquals("Male", outputZero.getSexo());
	        
	        PessoaVO outputSeven = outputList.get(7);
	        
	        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
	        Assert.assertEquals("First Name Test7", outputSeven.getNome());
	        Assert.assertEquals("Last Name Test7", outputSeven.getSobrenome());
	        Assert.assertEquals("Addres Test7", outputSeven.getEndereco());
	        Assert.assertEquals("Female", outputSeven.getSexo());
	        
	        PessoaVO outputTwelve = outputList.get(12);
	        
	        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
	        Assert.assertEquals("First Name Test12", outputTwelve.getNome());
	        Assert.assertEquals("Last Name Test12", outputTwelve.getSobrenome());
	        Assert.assertEquals("Addres Test12", outputTwelve.getEndereco());
	        Assert.assertEquals("Male", outputTwelve.getSexo());
	    }

	    @Test
	    public void parseVOToEntityTest() {
	        Pessoa output = DozerConverter.parseObject(inputObject.mockVO(), Pessoa.class);
	        Assert.assertEquals(Long.valueOf(0L), output.getId());
	        Assert.assertEquals("First Name Test0", output.getNome());
	        Assert.assertEquals("Last Name Test0", output.getSobrenome());
	        Assert.assertEquals("Addres Test0", output.getEndereco());
	        Assert.assertEquals("Male", output.getSexo());
	    }

	    @Test
	    public void parserVOListToEntityListTest() {
	        List<Pessoa> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Pessoa.class);
	        Pessoa outputZero = outputList.get(0);
	        
	        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
	        Assert.assertEquals("First Name Test0", outputZero.getNome());
	        Assert.assertEquals("Last Name Test0", outputZero.getSobrenome());
	        Assert.assertEquals("Addres Test0", outputZero.getEndereco());
	        Assert.assertEquals("Male", outputZero.getSexo());
	        
	        Pessoa outputSeven = outputList.get(7);
	        
	        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
	        Assert.assertEquals("First Name Test7", outputSeven.getNome());
	        Assert.assertEquals("Last Name Test7", outputSeven.getSobrenome());
	        Assert.assertEquals("Addres Test7", outputSeven.getEndereco());
	        Assert.assertEquals("Female", outputSeven.getSexo());
	        
	        Pessoa outputTwelve = outputList.get(12);
	        
	        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
	        Assert.assertEquals("First Name Test12", outputTwelve.getNome());
	        Assert.assertEquals("Last Name Test12", outputTwelve.getSobrenome());
	        Assert.assertEquals("Addres Test12", outputTwelve.getEndereco());
	        Assert.assertEquals("Male", outputTwelve.getSexo());
	    }
}
