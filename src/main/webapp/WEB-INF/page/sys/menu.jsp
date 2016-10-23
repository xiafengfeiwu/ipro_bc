<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath() + "/"%>" />
<title>${initParam.WEB_TITLE}</title>
<meta name="keywords" content="${initParam.WEB_KEYWORDS }">
<meta name="description" content="${initParam.WEB_DESCRIPTION }">
<link rel="shortcut icon" href="favicon.ico">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/ace.min.css">
</head>

<body>
	<div class="row">
		<div class="col-xs-12">
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-8">
					<div class="widget-box">
						<div class="widget-header header-color-green2">
							<h4 class="lighter smaller">Browse Files</h4>
						</div>

						<div class="widget-body">
							<div class="widget-main padding-8">
								<div id="tree2" class="tree tree-unselectable"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-2"></div>
			</div>
		</div>
	</div>

	<script src="resources/js/jquery.min.js?v=2.1.4"></script>
	<script src="resources/js/bootstrap.min.js?v=3.3.6"></script>
	<script src="resources/js/fuelux.tree.min.js"></script>
	<script src="resources/js/ace-elements.min.js"></script>
	<script src="resources/js/ace.min.js"></script>
	<script type="text/javascript">
	
		var remoteUrl = 'ajax/menualldata';
		
		jQuery(function($) {
			$.ajax({
				url : remoteUrl,
				type : 'get',
				dataType : 'json',
				success : function(response) {
					
					
					var remoteDateSource = function(options) {
						this._data 	= options.data;
					}
					
					remoteDateSource.prototype.data = function(options, callback) {
						var self = this;
						var $data = null;
						if(!("name" in options) && !("type" in options)){
							callback({
								data : response
							});	
							return;
						} else if ("type" in options && options.type == "folder") {
							if ("additionalParameters" in options && "children" in options.additionalParameters)
								$data = options.additionalParameters.children;
							else
								$data = {}
						}
						if ($data != null){
							callback({
								data : $data
							});	
						}
					};
					
					$('#tree2').ace_tree({
						dataSource : remoteDateSource,
						loadingHTML : '<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
						'selectable' : false
					});
				}
			});
		});
	</script>
</body>
</html>