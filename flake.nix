{
  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
    flake-parts.url = "github:hercules-ci/flake-parts";
    treefmt-nix.url = "github:numtide/treefmt-nix";
  };

  outputs =
    {
      self,
      nixpkgs,
      flake-parts,
      ...
    }@inputs:
    flake-parts.lib.mkFlake { inherit inputs; } {
      imports = [ ./nix/treefmt.nix ];

      systems = [ "x86_64-linux" ];

      perSystem =
        { pkgs, ... }:
        {
          devShells.default =
            let
              jdk = pkgs.openjdk17;

              libs = with pkgs; [
                libpulseaudio
                libGL
                glfw
                openal
                stdenv.cc.cc.lib
                jdk
              ];
            in
            pkgs.mkShell {
              buildInputs = libs;
              LD_LIBRARY_PATH = pkgs.lib.makeLibraryPath libs;
              JAVA_HOME = "${jdk}/lib/openjdk";
            };
        };
    };
}
