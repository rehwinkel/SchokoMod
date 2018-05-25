import os

item_name = input("Enter the Item's name: ")
tex_path = input("Enter the Texture path: ")
base = "{\n    \"parent\": \"item/generated\",\n    \"textures\": {\n        \"layer0\": \"noahschocolate:items/" + tex_path + "\"\n    }\n}"
f = open(item_name + ".json", 'w')
f.write(base)
f.close()
