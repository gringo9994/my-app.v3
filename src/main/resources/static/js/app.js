
// criação módulo principal da Aplicação
var appMedicamento=angular.module("appMedicamento",[]);


//criação dos controllers


appMedicamento.controller("indexController",function ($scope,$http){
	
	$scope.nome="Ivan  Nilson Kaiser";
	$scope.email="gringo9994@hotmail.com";
	
	
	
	$http({method:'GET',url:'http://localhost:8082/fabricante'})
	.then(function(response){
		
		console.log(response.nome);
	
		
	},function(response){
		
		console.log(response.nome);
		
	});
	
});