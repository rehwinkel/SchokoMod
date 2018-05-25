import os

item_name = "chocolate_bar_" + input("Enter the bar type name: ")
tex_path = "bars/" + item_name
base = "{\n    \"parent\": \"item/generated\",\n    \"textures\": {\n        \"layer0\": \"noahschocolate:items/" + tex_path + "\"\n    }\n}"
f = open(item_name + ".json", 'w')
f.write(base)
f.close()
