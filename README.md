Test with Mockito in a spring application.<br/>
This example uses ArgumentCaptor to check what parameters has a method been invoked with.<br/>
<br/>
compile & test :<br/>
mvn spring-boot:run<br/>
or<br/>
mvn test<br/>

<br/>
--HelloRepositoryImpl.java<br/>
public String returnParam(String myString) {<br/>
&nbsp;&nbsp;return myString;<br/>
<br/>
--HelloServiceImpl.java<br/>
@Autowired<br/>
HelloRepository helloRepository;<br/>
@Override<br/>
public String get(String myString) {<br/>
&nbsp;&nbsp;return helloRepository.returnParam(myString+"stringAddedByHelloService");<br/>
//basically, HelloServiceImpl.get is concatenating a String to pass to helloRepository.returnParam<br/> 
<br/>
--HelloServiceMockTest.java<br/>
<b>@Mock</b>//the mocked class<br/>
private HelloRepository helloRepository;<br/>
<b>@InjectMocks</b>//the class we inject the mocked class within<br/>
private HelloService helloService = new HelloServiceImpl();<br/>
@Test<br/>
void testReturnedValueWithMockito() {<br/>
&nbsp;&nbsp;//Arrange<br/>
&nbsp;&nbsp;// no arrange instruction...<br/>
&nbsp;&nbsp;//Act<br/>
&nbsp;&nbsp;<b>helloService.get("myString1");</b><br/>
&nbsp;&nbsp;//Assert<br/>
&nbsp;&nbsp;<b>ArgumentCaptor<String> myCaptor = ArgumentCaptor.forClass(String.class);<br/>
&nbsp;&nbsp;Mockito.verify(helloRepository).returnParam(myCaptor.capture());<br/>
&nbsp;&nbsp;assertEquals("myString1stringAddedByHelloService", myCaptor.getValue());</b><br/>
<br/>